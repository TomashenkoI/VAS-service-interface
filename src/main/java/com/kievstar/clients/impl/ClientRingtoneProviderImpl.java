package main.java.com.kievstar.clients.impl;

import main.java.com.kievstar.clients.ClientRingtoneProvider;
import main.java.com.kievstar.clients.ClientsDao;
import main.java.com.kievstar.clients.RingtonesService;

import java.util.List;

public class ClientRingtoneProviderImpl implements ClientRingtoneProvider {

    private ClientsDao clientsDao;
    private RingtonesService ringtonesService;


    @Override
    public List<String> getRingtones() {
        return ringtonesService.ringtones();
    }

    @Override
    public void buySelectedRingtone(int ringtoneId, int userId) {
        String ringtoneUrl = ringtonesService.getRingtoneById(ringtoneId);
        clientsDao.setRingtone(ringtoneUrl);
    }
}
