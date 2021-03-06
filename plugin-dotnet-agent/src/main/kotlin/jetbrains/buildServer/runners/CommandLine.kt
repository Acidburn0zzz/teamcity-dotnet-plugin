package jetbrains.buildServer.runners

import java.io.File

data class CommandLine(
        val target: TargetType,
        val executableFile: File,
        val workingDirectory: File,
        val arguments: Sequence<CommandLineArgument>,
        val environmentVariables: Sequence<CommandLineEnvironmentVariable>) {
}