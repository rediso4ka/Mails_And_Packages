package org.stepic.se.post;

import java.util.logging.Logger;

public class Spy implements MailService{

    public static final String AUSTIN_POWERS = "Austin Powers";

    private final Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailMessage)) return null;
        MailMessage msg = (MailMessage) mail;
        if (msg.getFrom() == AUSTIN_POWERS || msg.getTo() == AUSTIN_POWERS) {
            logger.warning(String.format("Detected target mail correspondence: from %s to %s \"%s\"", msg.getFrom(), msg.getTo(), msg.getMessage()));
        } else {
            logger.info(String.format("Usual correspondence: from %s to %s", msg.getFrom(), msg.getTo()));
        }
        return msg;
    }
}
