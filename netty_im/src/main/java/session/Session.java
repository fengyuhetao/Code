package session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HT
 * @version V1.0
 * @package session
 * @date 2019-05-14 18:40
 */
@Data
public class Session {
    private String userId;

    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Session{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
