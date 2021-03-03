package com.example.todotunh.service;

import com.example.todotunh.model.ResponseModel;
import com.example.todotunh.model.ToDo;
import com.example.todotunh.model.request.ToDoRequestModel;
import com.example.todotunh.model.response.ListToDoResponseModel;
import com.example.todotunh.model.response.ToDoResponse;
import com.example.todotunh.repository.ToDoRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    private static final String SUCCESS_STATUS = "SUCCESS";
    private static final String ERROR_STATUS = "ERROR";

    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public ResponseModel<ListToDoResponseModel> getAllWork() throws ServiceException {

        try {
            ListToDoResponseModel listToDoResponseModel = new ListToDoResponseModel();
            ResponseModel<ListToDoResponseModel> responseModel = new ResponseModel<>();
            List<ToDoResponse> listTodoWorkResponse = new ArrayList<>();

            List<ToDo> listToDo = toDoRepository.findAll();
            if (!listToDo.isEmpty()) {
                listToDo.forEach(x -> {
                    ToDoResponse temp = new ToDoResponse();
                    temp.setId(x.getId());
                    temp.setWorkName(x.getName());
                    temp.setStartingDate(_convertLongToTime(x.getStart()));
                    temp.setEndingDate(_convertLongToTime(x.getEnd()));
                    temp.setStatus(_convertStatus(x.getStatus()));

                    listTodoWorkResponse.add(temp);
                });
            }

            listToDoResponseModel.setListTodoWork(listTodoWorkResponse);
            responseModel.setResponse(listToDoResponseModel);
            responseModel.setStatus(SUCCESS_STATUS);

            return responseModel;
        } catch (Exception exception) {
            throw new ServiceException("ERROR: " + exception);
        }
    }

    @Override
    public ResponseModel<?> creatNewWork(ToDoRequestModel requestModel) {

        try {
            ResponseModel<?> responseModel = new ResponseModel<>();

            ToDo entity = new ToDo();
            entity.setName(requestModel.getWorkName());
            entity.setStart(_convertTimeToLong(requestModel.getStartingDate()));
            entity.setEnd(_convertTimeToLong(requestModel.getEndingDate()));
            entity.setStatus(requestModel.getStatus());

            toDoRepository.save(entity);
            responseModel.setStatus(SUCCESS_STATUS);

            return responseModel;
        } catch (Exception exception) {
            throw new ServiceException("ERROR: " + exception);
        }
    }

    private String _convertLongToTime(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return format.format(date);
    }

    private long _convertTimeToLong(String time) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(time);
        return date.getTime();
    }

    private String _convertStatus(int status) {

        switch (status) {
            case 1:
                return "Planning";
            case 2:
                return "Doing";
            case 3:
                return "Complete";
            default:
                return "";
        }
    }
}
