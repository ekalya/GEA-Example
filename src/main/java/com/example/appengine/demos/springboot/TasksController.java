/*
 * Copyright 2019 exk.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.appengine.demos.springboot;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author exk
 */
@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    TasksService taskService;

    @PostMapping("/")
    public HttpEntity<Task> create(@RequestBody Task task) {
        return new HttpEntity<>(this.taskService.create(task));
    }

    @GetMapping("/")
    public HttpEntity<Collection<Task>> findAll() {
        return new HttpEntity<>(this.taskService.findAll());
    }

    @GetMapping("/{id}")
    public HttpEntity<Optional<Task>> findById(@PathVariable("id") Long id) {
        return new HttpEntity<>(this.taskService.findById(id));
    }

    @PutMapping("/")
    public HttpEntity<Task> update(@RequestBody Task task) {
        return new HttpEntity<>(this.taskService.update(task));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.taskService.delete(id);
    }

}
