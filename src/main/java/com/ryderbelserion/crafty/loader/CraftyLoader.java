package com.ryderbelserion.crafty.loader;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.repository.RemoteRepository;
import org.jetbrains.annotations.NotNull;

public class CraftyLoader implements PluginLoader {

    @Override
    public void classloader(@NotNull PluginClasspathBuilder classpathBuilder) {
        MavenLibraryResolver resolver = new MavenLibraryResolver();

        // Aikar
        resolver.addDependency(new Dependency(new DefaultArtifact("co.aikar:acf-paper:0.5.1-SNAPSHOT"), null));

        // CrazyCrew
        resolver.addDependency(new Dependency(new DefaultArtifact("us.crazycrew.crazycore:crazycore-paper:1.0.0.3"), null));

        // Matt
        resolver.addDependency(new Dependency(new DefaultArtifact("dev.triumphteam:triumph-gui:3.1.2"),  null));

        // Other
        resolver.addDependency(new Dependency(new DefaultArtifact("ch.jalu:configme:1.3.0"), null));

        resolver.addRepository(new RemoteRepository.Builder("crazycrew-api", "default", "https://repo.crazycrew.us/api").build());
        resolver.addRepository(new RemoteRepository.Builder("aikar", "default", "https://repo.aikar.co/content/groups/aikar/").build());
        resolver.addRepository(new RemoteRepository.Builder("reposilite-repository-snapshots", "default", "https://repo.triumphteam.dev/snapshots/").build());
        resolver.addRepository(new RemoteRepository.Builder("jitpack", "default", "https://jitpack.io").build());

        classpathBuilder.addLibrary(resolver);
    }
}