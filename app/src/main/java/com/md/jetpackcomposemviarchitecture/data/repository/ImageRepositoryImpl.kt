package com.md.jetpackcomposemviarchitecture.data.repository

import com.md.jetpackcomposemviarchitecture.core.util.Resources
import com.md.jetpackcomposemviarchitecture.data.mapper.toImage
import com.md.jetpackcomposemviarchitecture.data.remote.ImageApi
import com.md.jetpackcomposemviarchitecture.domain.model.Image
import com.md.jetpackcomposemviarchitecture.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepositoryImpl @Inject constructor(
    private val imageApi: ImageApi
) : ImageRepository {
    override fun getImages(text: String): Flow<Resources<List<Image>>> {
        return flow {

            emit(Resources.Loading(true))

            val remoteList = try {
                imageApi.getInfiniteApiImages(text)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            }

            if (remoteList == null) {
                emit(Resources.Loading(false))
            }

            remoteList.let { listing ->
                println("====== $listing =========")
                emit(Resources.Success(data = listing?.images?.map { it.toImage() }))
                emit(Resources.Loading(false))
            }
        }
    }
}