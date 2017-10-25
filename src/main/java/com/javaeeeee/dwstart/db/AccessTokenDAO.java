package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.AccessToken;
import com.javaeeeee.dwstart.core.User;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;

import java.util.*;

public class AccessTokenDAO {
    private static Map<UUID, AccessToken> accessTokenTable = new HashMap<>();
/*
    public void initializeDefaultToken () {
        // SOLO PARA TESTING, BORRAR TODA LA FUNCION
        UUID defaultUUID = UUID.fromString("9fdfe272-8528-43f4-bd34-12324199a348");
        DateTime diaFuturo = new DateTime(DateTime.now());
        diaFuturo = diaFuturo.plusYears(1);
        User user = new User(9999,245);
        AccessToken defaultAccessToken = new AccessToken(defaultUUID,diaFuturo,user);
        accessTokenTable.put(defaultAccessToken.getToken(), defaultAccessToken);
    }
*/
    public Optional<AccessToken> findAccessTokenById(final UUID accessTokenId) {
        AccessToken accessToken = accessTokenTable.get(accessTokenId);
        if (accessToken == null) {
            return Optional.empty();
        }
        return Optional.of(accessToken);
    }

    public AccessToken generateNewAccessToken(final User user, final DateTime dateTime) {
        // recorro el hashmap eliminando los tokens expirados
        this.deleteExpiredTokens();

        AccessToken accessToken = new AccessToken(UUID.randomUUID(), dateTime, user);
        accessTokenTable.put(accessToken.getToken(), accessToken);
        return accessToken;
    }

    public void setLastAccessTime(final UUID token, final DateTime dateTime) {
        AccessToken accessToken = accessTokenTable.get(token);

        // BORRAR EL IF QUE NO ACTUALIZA EL TOKEN DEFAULT
        // seteo fecha actual y guardo token
        if (!token.equals(UUID.fromString("9fdfe272-8528-43f4-bd34-12324199a348"))) {
            accessToken.setLastAccessUTC(DateTime.now());
        }
        accessTokenTable.put(token, accessToken);
    }

    public void deleteExpiredTokens() {
        // ELIMINO TOKENS QUE TENGAN MÁS DE 1 DÍA
        Iterator<Map.Entry<UUID, AccessToken>> iterator = accessTokenTable.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<UUID, AccessToken> entry = iterator.next();
            // elimino tokens que tengan más de 1 día
            if (Days.daysBetween(entry.getValue().getLastAccessUTC(), new DateTime(DateTime.now())).getDays() > 1) {
                iterator.remove();
            }
        }
    }
}
