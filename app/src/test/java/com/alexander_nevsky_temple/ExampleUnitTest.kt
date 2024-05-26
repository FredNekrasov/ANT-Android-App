package com.alexander_nevsky_temple

import com.alexander_nevsky_temple.data.di.utils.DIStrings
import com.alexander_nevsky_temple.di.domainModule
import com.alexander_nevsky_temple.di.vmModule
import com.alexander_nevsky_temple.domain.model.Article
import com.alexander_nevsky_temple.domain.repositories.IArticleRepository
import com.alexander_nevsky_temple.domain.utils.ConnectionStatus
import com.alexander_nevsky_temple.presentation.viewModels.ArticleVM
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.dsl.*
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.koin.test.inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class ExampleUnitTest : KoinTest {
    private val fakeDataModule = module(createdAtStart = true) {
        singleOf(::FakeRepository) withOptions {
            bind<IArticleRepository>()
            named(DIStrings.ARTICLE + DIStrings.REPOSITORY)
            createdAtStart()
        }
    }
    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        startKoin {
            modules(fakeDataModule, domainModule, vmModule)
        }
    }
    private val articleVM: ArticleVM by inject<ArticleVM>(qualifier(DIStrings.ARTICLE + DIStrings.VIEWMODEL))
    @Test
    fun isLoading() {
        val res = articleVM.articlesSF.value
        assertNotNull(res.status)
        assertEquals(ConnectionStatus.LOADING, res.status)
        assertNotNull(res.list)
        assertEquals(emptyList<Article>(), res.list)
    }
    @Test
    fun isCorrectData(): Unit = runTest {
        val res = articleVM.articlesSF.value
        delay(1000L)
        assertEquals(ConnectionStatus.SUCCESS, res.status)
        assertEquals(5, res.list.size)
        assertNotNull(res.list.firstOrNull())
        assertEquals("title1", res.list.firstOrNull()?.title)
        assertEquals(
            Article("title1", "description1", "date1", "1", listOf("a", "1")),
            res.list.firstOrNull()
        )
    }
    @Test
    fun verifyKoinApp() = getKoin().checkModules()
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        stopKoin()
    }
}