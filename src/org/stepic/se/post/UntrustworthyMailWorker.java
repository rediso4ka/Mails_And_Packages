package org.stepic.se.post;

public class UntrustworthyMailWorker implements MailService{

    public final MailService[] persons;
    public final RealMailService realWorker = new RealMailService();

    public UntrustworthyMailWorker(MailService[] persons) {
        this.persons = persons;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService person: persons){
            person.processMail(mail);
        }
        getRealMailService().processMail(mail);
        return mail;
    }

    public RealMailService getRealMailService(){
        return realWorker;
    }
}
