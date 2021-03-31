package com.baetory.domain.usecase.book

import com.baetory.domain.BookRepository
import com.baetory.domain.UseCaseTest
import io.reactivex.rxjava3.core.Completable
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class DeleteCashedBooksUseCaseTest : UseCaseTest() {

    private lateinit var deleteCachedBooksUseCase: DeleteCachedBooksUseCase

    @Mock
    private lateinit var bookRepository: BookRepository

    override fun setup() {
        super.setup()
        deleteCachedBooksUseCase = DeleteCachedBooksUseCase(
            bookRepository = bookRepository,
            executorProvider = testExecutors
        )
    }

    @Test
    fun `Delete 후 complete 여부 테스트`() {
        Mockito.`when`(
            bookRepository.dropBooks()
        )
            .thenReturn(Completable.complete())

        deleteCachedBooksUseCase.execute().test().assertComplete()
    }
}