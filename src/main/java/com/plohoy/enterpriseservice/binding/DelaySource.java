package com.plohoy.enterpriseservice.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * The interface Delay source.
 */
public interface DelaySource {

    String OUTPUT = "delayOutput";

    /**
     * Output message channel.
     *
     * @return the message channel
     */
    @Output(DelaySource.OUTPUT)
    MessageChannel output();
}
