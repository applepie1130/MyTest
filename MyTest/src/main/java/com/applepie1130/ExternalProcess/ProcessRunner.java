package com.applepie1130.ExternalProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;


/**
 * 명령어를 통해 외부 프로세스 실행 (터미널명령어)
 *
 * {@link} http://d2.naver.com/helloworld/1113548
 * @author sungjun.kim
 */
public class ProcessRunner {

	public static void main(String[] args) throws IOException, InterruptedException {
		runTimeExec();
		processBuilder();
		apacheCommonExec();
	}


	// Runtime 클래스를 이용한 외부 프로세스 실행
	private static void runTimeExec() throws IOException, InterruptedException {

		String[] commands = { "ls", "-al" };

		Process process = Runtime.getRuntime().exec(commands);
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String commandLine = null;

		while ((commandLine = br.readLine()) != null) {
			System.out.println(commandLine);
		}

		process.getErrorStream().close();
		process.getOutputStream().close();
		process.getInputStream().close();
		process.waitFor();
	}

	// ProcessBuilder 클래스의 redirectOutput() 메서드 활용
	private static void processBuilder() throws IOException {

		String[] commands = { "ls", "-al" };

		ProcessBuilder builder = new ProcessBuilder(commands);
		builder.redirectOutput(Redirect.INHERIT);
		builder.redirectError(Redirect.INHERIT);
		builder.start();
	}


	// Apache Comons Exec를 활용한 명령어 실행
	private static void apacheCommonExec() throws ExecuteException, IOException {

		String[] commands = { "ls", "-al" };

		DefaultExecutor executor = new DefaultExecutor();
		CommandLine cmdLine = CommandLine.parse(commands[0]);

		for (int i=1, n=commands.length ; i<n ; i++ ) {
			cmdLine.addArgument(commands[i]);
		}
		executor.execute(cmdLine);
	}
}
