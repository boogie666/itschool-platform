package com.itschool.platform;

import com.itschool.platform.core.Interactor;
import com.itschool.platform.files.StaticFileInteractor;
import com.itschool.platform.questions.AllQuestionsInteractor;
import com.itschool.platform.router.RouterInteractor;
import org.eclipse.jetty.server.Server;

import com.itschool.platform.util.HandlerAdapter;

public class Main {

	public static void main(String[] args) throws Exception {
		final Server s = new Server(8080);

		final Interactor allQuestions = new AllQuestionsInteractor("resources/questions");
		final Interactor files = new StaticFileInteractor("resources/public");
		final Interactor router = new RouterInteractor(allQuestions, files);
		s.setHandler(new HandlerAdapter(router));
		s.start();
		s.join();

	}

}
