package demo.chat

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CreatorService {

    fun checkCreator(): Boolean {
        return false
    }
}
