package com.github.ogaemma.argus.core;

import com.github.ogaemma.argus.exception.ArgusException;
import com.github.ogaemma.argus.model.ArgusEvent;

public interface ArgusEventListener {
    void onEvent(ArgusEvent argusEvent);
    void onException(ArgusException exception);
}
