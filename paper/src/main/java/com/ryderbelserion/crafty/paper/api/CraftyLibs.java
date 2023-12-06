package com.ryderbelserion.crafty.paper.api;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.repository.RemoteRepository;
import org.jetbrains.annotations.NotNull;

public class CraftyLibs implements PluginLoader {

    @Override
    public void classloader(@NotNull PluginClasspathBuilder classpathBuilder) {
        MavenLibraryResolver resolver = new MavenLibraryResolver();

        // Other
        resolver.addDependency(new Dependency(new DefaultArtifact("ch.jalu:configme:1.4.1"), null));

        resolver.addRepository(new RemoteRepository.Builder("crazycrew-api", "default", "https://repo.crazycrew.us/api").build());
        resolver.addRepository(new RemoteRepository.Builder("jitpack", "default", "https://jitpack.io").build());

        classpathBuilder.addLibrary(resolver);
    }
}