package com.example.data.di

import com.example.core.REST_PUBLIC_CLIENT_MODULE
import com.example.data.remotesource.WeatherRemoteSource
import com.example.data.remotesource.WeatherRemoteSourceImpl
import com.example.data.remotesource.api.GetWeatherApi
import com.example.data.remotesource.mapper.WeatherMapper
import com.example.data.remotesource.mapper.WeatherMapperImpl
import com.example.data.repository.WeatherRepositoryImpl
import com.example.domain.repository.WeatherRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single<GetWeatherApi> { get<Retrofit>(named(REST_PUBLIC_CLIENT_MODULE)).create(GetWeatherApi::class.java) }
}

val repositoryModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl(source = get()) }
}

val sourceModule = module {
    single<WeatherRemoteSource> {
        WeatherRemoteSourceImpl(
            getWeatherApi = get(), mapper = get()
        )
    }
}

val mapperModule = module {
    single<WeatherMapper> { WeatherMapperImpl() }
}