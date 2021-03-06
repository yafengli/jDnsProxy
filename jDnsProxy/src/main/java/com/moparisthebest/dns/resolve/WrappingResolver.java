package com.moparisthebest.dns.resolve;

import com.moparisthebest.dns.dto.Packet;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public abstract class WrappingResolver implements Resolver {

    protected final Resolver delegate;

    public WrappingResolver(final Resolver delegate) {
        Objects.requireNonNull(delegate);
        this.delegate = delegate;
    }

    @Override
    public CompletableFuture<Packet> resolveAsync(final Packet request, final Executor executor) {
        return delegate.resolveAsync(request, executor);
    }

    @Override
    public Packet resolve(final Packet request) throws Exception {
        return delegate.resolve(request);
    }

    // we don't call delegate.close() on purpose, whatever created it should close it
}
