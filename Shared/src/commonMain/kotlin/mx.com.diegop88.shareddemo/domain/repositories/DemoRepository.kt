package mx.com.diegop88.shareddemo.domain.repositories

import mx.com.diegop88.shareddemo.data.DemoService
import mx.com.diegop88.shareddemo.domain.usecases.models.Country
import mx.com.diegop88.shareddemo.utils.Resource

class DemoRepository(private val demoService: DemoService) {

    suspend fun getAllCountries() = try {
        val result = demoService.getAllCountries().map { Country(it.name, it.capital) }
        Resource.Success(result)
    } catch (exception: Exception) {
        Resource.Error(exception)
    }
}
