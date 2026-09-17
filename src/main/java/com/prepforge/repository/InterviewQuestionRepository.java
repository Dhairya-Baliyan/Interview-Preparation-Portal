package com.prepforge.repository;

import com.prepforge.model.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.prepforge.model.Category;
import com.prepforge.model.Difficulty;

public interface InterviewQuestionRepository
    extends JpaRepository<InterviewQuestion, Long>{
    List<InterviewQuestion> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String titleKeyword,
            String descriptionKeyword
    );

    List<InterviewQuestion> findByCategory(Category category);

    List<InterviewQuestion> findByDifficulty(Difficulty difficulty);
}
