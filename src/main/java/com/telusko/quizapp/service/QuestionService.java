package com.telusko.quizapp.service;

import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.telusko.quizapp.exception.QuestionNotFoundException;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    public ResponseEntity<List<Question>> getAllQuestions(){
        logger.info("Fetching all questions");
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error occurred while fetching questions", e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        logger.info("Fetching questions for category {}", category);
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error occurred while fetching questions", e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        logger.info("Adding new question");
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        logger.info("Deleting question with id {}", id);
        try{
            questionDao.deleteById(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error occurred while deleting questions", e);
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(int id, Question updatedQuestion) {
        logger.info("Updating question with id {}", id);
        try{
            Question question = questionDao.findById(id).orElseThrow(() -> new QuestionNotFoundException("Question not found"));
            question.setQuestionTitle(updatedQuestion.getQuestionTitle());
            question.setOption1(updatedQuestion.getOption1());
            question.setOption2(updatedQuestion.getOption2());
            question.setOption3(updatedQuestion.getOption3());
            question.setOption4(updatedQuestion.getOption4());
            question.setRightAnswer(updatedQuestion.getRightAnswer());
            question.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
            question.setCategory(updatedQuestion.getCategory());
            questionDao.save(question);
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }catch (QuestionNotFoundException e){
            throw e;
        }
        catch (Exception e){
            logger.error("Error occurred while updating questions", e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
