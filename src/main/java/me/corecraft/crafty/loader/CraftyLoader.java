package me.corecraft.crafty.loader;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver;
import org.jetbrains.annotations.NotNull;

public class CraftyLoader implements PluginLoader {

    @Override
    public void classloader(@NotNull PluginClasspathBuilder classpathBuilder) {
        MavenLibraryResolver resolver = new MavenLibraryResolver();

        //resolver.addDependency(new Dependency(new DefaultArtifact("us.crazycrew.crazycore:crazycore-paper:0.0.0.2"), null));

        // Triumph Team.
        //resolver.addDependency(new Dependency(new DefaultArtifact("dev.triumphteam:triumph-cmd-bukkit:2.0.0-ALPHA-7"), null));
        //resolver.addDependency(new Dependency(new DefaultArtifact("dev.triumphteam:triumph-gui:3.1.2"), null));

        // Configs
        //resolver.addDependency(new Dependency(new DefaultArtifact("ch.jalu:configme:1.3.0"), null));

        //resolver.addRepository(new RemoteRepository.Builder("crazycrew-api", "default", "https://repo.crazycrew.us/api/").build());

        //resolver.addRepository(new RemoteRepository.Builder("reposilite-repository-snapshots", "default", "https://repo.triumphteam.dev/snapshots/").build());

        //resolver.addRepository(new RemoteRepository.Builder("maven2", "default", "https://repo1.maven.org/maven2").build());
        //resolver.addRepository(new RemoteRepository.Builder("jitpack", "default", "https://jitpack.io").build());

        classpathBuilder.addLibrary(resolver);
    }
}