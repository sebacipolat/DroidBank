package com.cipolat.droidbank.data.home.repositories

import com.cipolat.droidbank.data.home.datasource.HomeLocalDataSource
import com.cipolat.droidbank.data.home.datasource.HomeRemoteDataSource
import com.cipolat.droidbank.data.home.local.entity.HomeResponseEntity
import com.cipolat.droidbank.data.home.local.entity.asHomeBody
import com.cipolat.droidbank.data.home.model.HomeBody
import com.cipolat.droidbank.data.home.remote.model.asHomeBody
import com.cipolat.droidbank.data.network.Resource
import com.cipolat.droidbank.data.network.Resource.Status.ERROR
import com.cipolat.droidbank.data.network.Resource.Status.LOADING
import com.cipolat.droidbank.data.network.Resource.Status.SUCCESS
import com.cipolat.droidbank.data.utils.DateUtils

class HomeRepositoryImpl(
    private val homeLocalDataSource: HomeLocalDataSource,
    private val remoteDataSource: HomeRemoteDataSource
) : HomeRepository {

    override suspend fun getHomeUserData(cacheTimeLimit: Long): Resource<HomeBody> {
        val localUserData = homeLocalDataSource.getHomeData()
        return if (localUserData != null) {
            if (DateUtils.isTimeStampChild(
                    localUserData.balance.lastUpdate.toLong(),
                    cacheTimeLimit
                )
            ) {
                Resource.success(localUserData.asHomeBody())
            } else {
                getRemoteHome(true, localUserData)
            }
        } else {
            getRemoteHome(false)
        }
    }

    suspend fun getRemoteHome(
        hasCache: Boolean,
        homeResponseEntity: HomeResponseEntity? = null
    ): Resource<HomeBody> {
        val remoteResponse = remoteDataSource.getHomeData()
        when (remoteResponse.status) {
            SUCCESS -> {
                homeLocalDataSource.saveHomeData(remoteResponse.data!!)
                return Resource.success(remoteResponse.data.asHomeBody())
            }

            ERROR -> {
                return Resource.error(
                    errorType = remoteResponse.errorType,
                    data = if (hasCache) homeResponseEntity!!.asHomeBody() else null
                )
            }

            LOADING -> TODO()
        }
    }
}
