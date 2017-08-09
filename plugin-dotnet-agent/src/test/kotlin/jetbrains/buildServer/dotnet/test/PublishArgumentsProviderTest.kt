package jetbrains.buildServer.dotnet.test

import jetbrains.buildServer.dotnet.DotnetConstants
import jetbrains.buildServer.dotnet.arguments.PublishArgumentsProvider
import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class PublishArgumentsProviderTest {
    @DataProvider
    fun testPublishArgumentsData(): Array<Array<Any>> {
        return arrayOf(
                arrayOf(mapOf(Pair(DotnetConstants.PARAM_PATHS, "path/")), listOf("publish", "path/")),
                arrayOf(mapOf(
                        Pair(DotnetConstants.PARAM_PUBLISH_FRAMEWORK, "dotcore"),
                        Pair(DotnetConstants.PARAM_PUBLISH_CONFIG, "Release")),
                        listOf("publish", "--framework", "dotcore", "--configuration", "Release")),
                arrayOf(mapOf(
                        DotnetConstants.PARAM_PUBLISH_RUNTIME to " active",
                        DotnetConstants.PARAM_VERBOSITY to "normal "),
                        listOf("publish", "--runtime", "active", "--verbosity", "normal")),
                arrayOf(mapOf(
                        Pair(DotnetConstants.PARAM_PUBLISH_OUTPUT, "out"),
                        Pair(DotnetConstants.PARAM_PUBLISH_CONFIG, "Release")),
                        listOf("publish", "--configuration", "Release", "--output", "out")),
                arrayOf(mapOf(
                        DotnetConstants.PARAM_PUBLISH_OUTPUT to "c:\\build\\out",
                        DotnetConstants.PARAM_PATHS to "project.csproj",
                        DotnetConstants.PARAM_PUBLISH_CONFIG to "Release"),
                        listOf("publish", "project.csproj", "--configuration", "Release", "--output", "c:\\build\\out"))
        )
    }

    @Test(dataProvider = "testPublishArgumentsData")
    fun shouldGetArguments(
            parameters: Map<String, String>,
            expectedArguments: List<String>) {
        // Given
        val argumentsProvider = PublishArgumentsProvider(ParametersServiceStub(parameters), ArgumentsServiceStub())

        // When
        val actualArguments = argumentsProvider.getArguments().map { it.value }.toList()

        // Then
        Assert.assertEquals(actualArguments, expectedArguments)
    }
}