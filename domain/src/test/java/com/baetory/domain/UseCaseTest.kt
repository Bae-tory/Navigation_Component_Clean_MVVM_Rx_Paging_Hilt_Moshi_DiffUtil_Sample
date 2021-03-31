package com.baetory.domain

import com.baetory.mock.TestExecutors
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.rules.ExpectedException
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

abstract class UseCaseTest {

    @get: Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get: Rule
    val expectException: ExpectedException = ExpectedException.none()

    protected lateinit var testExecutors: TestExecutors

    @Before
    open fun setup() {
        MockitoAnnotations.initMocks(this)
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        testExecutors = TestExecutors()
    }

}