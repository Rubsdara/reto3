package com.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.ciclo3.model.Message;
import com.usa.ciclo3.ciclo3.repository.MessageRepository;

/**
 *
 * @author lilia
 */

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public List<Message> getAll() {//
		return messageRepository.getAll();
	}

	public Optional<Message> getMessage(int id) {
		return messageRepository.getMessage(id);
	}

	public Message save(Message mensaje) {
		if (mensaje.getIdMessage() == null) {
			return messageRepository.save(mensaje);

		} else {
			Optional<Message> mensajeAuxOptional = messageRepository.getMessage(mensaje.getIdMessage());
			if (mensajeAuxOptional.isEmpty()) {
				return messageRepository.save(mensaje);
			} else {
				return mensaje;
			}
		}
	}
}
