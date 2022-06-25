package org.stepic.se.post;

public class Thief implements MailService{

    public final int min_price;
    public static int summary = 0;

    public Thief(int min_price) {
        this.min_price = min_price;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if(!(mail instanceof MailPackage)) return mail;
        MailPackage mailPackage = (MailPackage) mail;
        if (mailPackage.getContent().getPrice() >= min_price){
            summary += mailPackage.getContent().getPrice();
            Package pkg = new Package(String.format("stones instead of %s", mailPackage.getContent().getContent()), 0);
            MailPackage mail_pkg = new MailPackage(mailPackage.getFrom(), mailPackage.getTo(), pkg);
            return mail_pkg;
        }
        return mail;
    }

    public int getStolenValue(){
        return summary;
    }
}
