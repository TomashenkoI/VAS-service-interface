package main.java.com.kievstar.clients;

import java.util.List;

public interface ClientRingtoneProvider {

    List<String> getRingtones();

    void buySelectedRingtone(int ringtoneId, int userId);

}
