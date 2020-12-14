CREATE OR REPLACE PROCEDURE sp_users_login
(
    v_userid     IN      users.userid%TYPE,
    v_passwd     IN      users.passwd%TYPE,
    v_result     OUT     NUMBER
)
IS
    t_passwd users.passwd%TYPE;
BEGIN
    SELECT passwd INTO t_passwd
    FROM Users
    WHERE userid = v_userid;    

    IF t_passwd = NULL THEN -- 그런 아이디가 없다면
        v_result := -1;
    ELSE  -- 그런 아이디가 있다면
        IF v_passwd = t_passwd THEN -- 패스워드가 일치한다면
            v_result := 1;
        ELSE  -- 패스워드가 일치하지 않는다면
            v_result := 0;
        END IF;
    END IF;
    
    Exception
        WHEN NO_DATA_FOUND THEN -- 그런 아이디가 없다면
            v_result := -1;
END;


ALTER TABLE Users
Add (flag NUMBER(1) DEFAULT 1);