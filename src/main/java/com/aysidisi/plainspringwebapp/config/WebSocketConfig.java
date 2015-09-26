
package com.aysidisi.plainspringwebapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer
{
	@Override
	public void configureClientInboundChannel(final ChannelRegistration registration)
	{
		registration.setInterceptors(new CustomChannelInterceptor());
	}

	@Override
	public void configureClientOutboundChannel(final ChannelRegistration registration)
	{
		registration.setInterceptors(new CustomChannelInterceptor());
	}

	@Override
	public void configureMessageBroker(final MessageBrokerRegistry registry)
	{
		registry.enableSimpleBroker("/adventure");
		registry.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(final StompEndpointRegistry registry)
	{
		registry.addEndpoint("/chatreg").withSockJS();
		registry.addEndpoint("/worldofdayum").withSockJS();
	}
	
}