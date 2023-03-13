package com.skypro.springtest.model;
import com.skypro.springtest.exception.InvalidDataException;

    public class User {
        private final String login;
        private final String eMail;

        public User(String login, String eMail) {
            if (login == null || login.isBlank() || login.isEmpty()) {
                login = "Unknown";
            }
            else if (login.contentEquals(eMail)) {
                throw new InvalidDataException();
            }

            if (eMail == null || eMail.isBlank() || login.isEmpty()) {
                eMail = "Unknown";
            }
            else if (!eMail.contains("@") || !eMail.contains(".")) {
                throw new InvalidDataException();
            }

            this.login = login;
            this.eMail = eMail;
        }

        public String getLogin() {
            return login;
        }

        public String geteMail() {
            return eMail;
        }
    }

