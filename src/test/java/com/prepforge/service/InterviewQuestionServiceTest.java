package com.prepforge.service;

import com.prepforge.model.Category;
import com.prepforge.model.Difficulty;
import com.prepforge.model.InterviewQuestion;
import com.prepforge.repository.InterviewQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class InterviewQuestionServiceTest {
    @Mock
    private InterviewQuestionRepository interviewQuestionRepository;

    @InjectMocks
    private InterviewQuestionService interviewQuestionService;

    @Test
    void shouldReturnAllQuestions() {
        InterviewQuestion question = new InterviewQuestion(
                "What is inheritance?",
                "A question about inheritance",
                Category.OOP,
                Difficulty.EASY,
                "Inheritance allows a class to reuse another class behavior",
                "It is an object oriented programming concept"
        );

        List<InterviewQuestion> questions = List.of(question);

        when(interviewQuestionRepository.findAll()).thenReturn(questions);

        List<InterviewQuestion> result = interviewQuestionService.getAllQuestions();

        assertEquals(1, result.size());
        assertEquals("What is inheritance?", result.get(0).getTitle());
    }
}