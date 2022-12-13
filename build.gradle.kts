import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
	`java-library`
	id("xyz.jpenilla.run-paper") version "1.1.0"
	id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

val mc = "1.19.2"
group = "shateq.bukkit"
version = "1.0.0"
description = "Minecraft Server Enchantments experience"
base.archivesName.set("simon-the-enchanter-$mc")

repositories {
	mavenCentral()
	maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
	compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

tasks {
	compileJava {
		options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
		options.release.set(17)
	}
	processResources {
		filteringCharset = Charsets.UTF_8.name()
	}
	runServer {
		minecraftVersion.set("1.19.2")
	}
}

bukkit {
	name = "SimonTheEnchanter"
	version = project.version.toString()
	main = "shateq.theenchanter.bukkit.BukkitEnchants"
	apiVersion = "1.19"

	load = BukkitPluginDescription.PluginLoadOrder.STARTUP
	prefix = "STE"
	authors = listOf("Shateq")
	softDepend = listOf("ProtocolLib")
}
