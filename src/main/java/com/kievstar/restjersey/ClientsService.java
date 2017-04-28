package main.java.com.kievstar.restjersey;

import main.java.com.kievstar.clients.ClientRingtoneProvider;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/user-{userId}/ringtones")
public class ClientsService {

    @Autowired
    private ClientRingtoneProvider clientRingtoneProvider;

    @GET
    @Produces("application/json")
    public Response getListOfRingtones() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("listOfRingtones", clientRingtoneProvider.getRingtones());
        String result = "@Produces(\"application/json\") Output: \n" + jsonObject;
        return Response.status(200).entity(result).build();

    }

    @GET
    @Produces("application/json")
    @Path("/buy/{ringtoneId}")
    public Response buyRingtone(@PathParam("ringtoneId") int ringtoneId,
                                @PathParam("userId") int userId) {

        clientRingtoneProvider.buySelectedRingtone(ringtoneId, userId);

        return Response.status(200).build();
    }

    public void setClientRingtoneProvider(ClientRingtoneProvider clientRingtoneProvider) {
        this.clientRingtoneProvider = clientRingtoneProvider;
    }

}
