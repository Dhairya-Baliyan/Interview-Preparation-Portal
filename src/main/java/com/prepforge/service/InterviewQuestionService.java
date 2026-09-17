package com.prepforge.service;

import com.prepforge.model.Category;
import com.prepforge.model.Difficulty;
import com.prepforge.model.InterviewQuestion;
import com.prepforge.repository.InterviewQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class InterviewQuestionService{
    private final InterviewQuestionRepository interviewQuestionRepository;

    public InterviewQuestionService(
            InterviewQuestionRepository interviewQuestionRepository){
        this.interviewQuestionRepository =interviewQuestionRepository;
    }

    public List<InterviewQuestion> getAllQuestions(){
        return interviewQuestionRepository.findAll();
    }

    public Optional<InterviewQuestion> getQuestionById(Long id) {
        return interviewQuestionRepository.findById(id);
    }

    // Create
    public InterviewQuestion createQuestion(InterviewQuestion question){
        return interviewQuestionRepository.save(question);
    }

    // Update
    public Optional<InterviewQuestion> updateQuestion(Long id, InterviewQuestion updatedQuestion){
        Optional<InterviewQuestion> result = interviewQuestionRepository.findById(id);

        if (result.isEmpty())
            return Optional.empty();

        InterviewQuestion existingQuestion = result.get();

        existingQuestion.setTitle(updatedQuestion.getTitle());
        existingQuestion.setDescription(updatedQuestion.getDescription());
        existingQuestion.setCategory(updatedQuestion.getCategory());
        existingQuestion.setDifficulty(updatedQuestion.getDifficulty());
        existingQuestion.setExplanation(updatedQuestion.getExplanation());
        existingQuestion.setAnswer(updatedQuestion.getAnswer());

        InterviewQuestion savedQuestion = interviewQuestionRepository.save(existingQuestion);

        return Optional.of(savedQuestion);
    }

    // Delete
    public boolean deleteQuestion(Long id){
        if (!interviewQuestionRepository.existsById(id))
            return false;
        interviewQuestionRepository.deleteById(id);
        return true;
    }

    public List<InterviewQuestion> searchQuestion(
            String keyword,
            Category category,
            Difficulty difficulty){
        List<InterviewQuestion> questions = getAllQuestions();

        List<InterviewQuestion> filteredQuestion = questions.stream()
                .filter(question ->
                        keyword == null ||
                        keyword.isBlank()||
                        question.getTitle().toLowerCase().contains(keyword.toLowerCase())||
                        question.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .filter(question ->
                        category == null||
                        question.getCategory() == category)
                .filter(question ->
                        difficulty == null||
                        question.getDifficulty() == difficulty)
                .toList();

        return filteredQuestion;
    }
}