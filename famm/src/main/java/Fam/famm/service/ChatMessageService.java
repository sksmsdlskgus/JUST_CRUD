package Fam.famm.service;

import Fam.famm.dto.ChatMessage;
import Fam.famm.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void publish(String roomId, ChatMessage message) {
        message.setRoomId(roomId);
        // WebSocket을 통해 메시지를 해당 토픽으로 전송
        messagingTemplate.convertAndSend("/sub/chat/room/" + roomId, message);
        // 데이터베이스에 메시지 저장
        chatMessageRepository.save(message);
    }
}

