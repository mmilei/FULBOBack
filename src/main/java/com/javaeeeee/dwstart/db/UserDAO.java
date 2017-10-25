package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


@RegisterMapper(UserMapper.class)
public interface UserDAO {

    @SqlQuery(" SELECT id, " +
            "       usuario, " +
            "       nombre, " +
            "       apellido, " +
            "       email, " +
            "       telefono, " +
            "       id_cliente, " +
            "       rol" +
            "  FROM sigoweb.tusuario " +
            " WHERE usuario = lower(trim(:username))" +
            //"   AND contrasenia = LOWER (DBMS_CRYPTO.hash (TO_CLOB (:password), 2)) ")
            "   AND contrasenia = LOWER (:password) "
    )
    User getUserByUsernameAndPassword (@Bind("username") String username,
                                       @Bind("password") String password);

    @SqlUpdate("UPDATE sigoweb.tusuario " +
            " SET contrasenia = LOWER (DBMS_CRYPTO.hash (TO_CLOB (:new_password), 2))," +
            "   fmodif = sysdate " +
            " where id = :id_user")
    void cambiarPassword (@Bind("id_user") int idUser,
                          @Bind("new_password") String newPassword);

}