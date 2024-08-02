package com.exe.coffeemachine.emulator.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Реализация AuditorAware для предоставления информации об аудиторе
 * @author user
 * @year 2024
 */
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    /**
     * Возвращает текущего аудитора приложения.
     *
     * @return текущий аудитор.
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("COFFEE_MACHINE_EMULATOR");
    }
}
