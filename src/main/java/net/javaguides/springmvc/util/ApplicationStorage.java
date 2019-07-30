package net.javaguides.springmvc.util;

import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

public final class ApplicationStorage {

    private static final ApplicationStorage INSTANCE = new ApplicationStorage();

    private final Set<String> processingEmails;

    private ApplicationStorage() {
        this.processingEmails = new HashSet<>();
    }

    public static ApplicationStorage getInstance() {
        return INSTANCE;
    }

    public boolean processEmail(final String email) {
        synchronized (ApplicationStorage.class) {
            Assert.hasText(email, "email cannot be null or empty.");
            return processingEmails.add(email);
        }
    }

    public void unProcessEmail(final String email) {
        synchronized (ApplicationStorage.class) {
            Assert.hasText(email, "email cannot be null or empty.");
            processingEmails.remove(email);
        }
    }
}