package org.example.storage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.TaskDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private final List<TaskDTO> tasks = new ArrayList<>();
    private int nextId = 1;
    private final ObjectMapper mapper = new ObjectMapper();

    public void addTask(TaskDTO task) {
        task.setId(nextId++);
        task.setDataCriacao(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        tasks.add(task);
    }

    public String findTaskById(int id) {
        for (TaskDTO task : tasks) {
            if (task.getId() == id) {
                try {
                    return mapper.writeValueAsString(task);
                } catch (Exception e) {
                    throw new RuntimeException("Erro ao converter a tarefa em algum formato de envio: " + e.getMessage());
                }
            }
        }
        return null;
    }

    public String getAllTasks() {
        try {
            return mapper.writeValueAsString(tasks);
        } catch (Exception e) {
            return "[]";
        }
    }
}