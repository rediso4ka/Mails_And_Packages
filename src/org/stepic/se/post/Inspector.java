package org.stepic.se.post;

public class Inspector implements MailService{

    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public Inspector() {
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailPackage)) return null;
        MailPackage mailPackage = (MailPackage) mail;
        if (mailPackage.getContent().getContent().contains("stones")){
            throw new StolenPackageException("stones!");
        } else if (mailPackage.getContent().getContent().contains(WEAPONS) ||
                    mailPackage.getContent().getContent().contains(BANNED_SUBSTANCE)){
            throw new IllegalPackageException("weapons or smthg banned!");
        }
        return mail;
    }
}
