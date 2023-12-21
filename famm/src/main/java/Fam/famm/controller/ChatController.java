package Fam.famm.controller;


import Fam.famm.dto.ChatMessage;
import Fam.famm.repository.ChatMessageRepository;
import Fam.famm.repository.ChatRoomRepository;
import Fam.famm.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/msg")
public class ChatController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    private ChatMessageService chatMessageService;
    private final ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chat/message") // 채팅 메시지 전송
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }

        // 채팅 메시지를 데이터베이스에 저장하고 전송
        chatMessageService.publish(message.getRoomId(), message);
    }


    @GetMapping("/msg/all") //전체 채팅 내용 조회
    @ResponseBody
    public List<ChatMessage> getAllChatMessages() {
        return chatMessageRepository.findAll();
    }
}