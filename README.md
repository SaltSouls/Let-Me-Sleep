<div align="center"><img src="https://cdn.modrinth.com/data/cached_images/9a1df43af41ee5516e157dea1cc2f532b7380e43.png" /></div>

[//]: # (<div align="center">)

[//]: # (	<img src="https://img.shields.io/badge/mod%20loader-forge%20%2F%20neoforge-blue?style=flat-square" />)

[//]: # (	<img src="https://img.shields.io/modrinth/game-versions/gfvSVUz9?style=flat-square&label=avaliable%20for&color=blue" />)

[//]: # (	<img src="https://img.shields.io/modrinth/dt/gfvSVUz9?style=flat-square&logo=modrinth&logoSize=auto&color=4caf50" />)

[//]: # (	<img src="https://img.shields.io/curseforge/dt/683324?style=flat-square&logo=curseforge&logoSize=auto&color=4caf50" />)

[//]: # (</div>)

**Let Me Sleep** is a simple mod designed around the idea of making the monster check when trying to sleep more sensible. This is done by making it so that only monsters currently tracking the player will prevent sleeping.

No more restless nights hunting for monsters that won't **Let Me Sleep**.

## Info:
This mod is highly configurable, and most aspects of what this mod does can be adjusted to suit your needs.

```toml
#General Settings
[general]
    #Should nearby monsters prevent sleep?
    monsterCheck = true
    #Should only monsters tracking the player prevent sleep? [Requires monsterCheck]
    betterChecking = true
    #Horizontal radius to check for mobs when sleeping. [Requires betterChecking]
    #Range: 0 ~ 256
    horizontalRange = 32
    #Vertical radius to check for mobs when sleeping. [Requires betterChecking]
    #Range: 0 ~ 64
    verticalRange = 16
```
<details>
  <summary><b>FAQ:</b></summary>

**Q: Where should I leave suggestions or feedback?**

A: I would love to hear any suggestions or feedback you have! I only ask that you leave it as a new issue here as it makes it easier for me to manage and track.

**Q: Can I use this in my modpack?**

A: Absolutely! I only ask that you give credit if you do. Other than that, feel free to include it and modify it however you see fit for your pack.

**Q: What version(s) will be supported?**

A: Only the latest major version will be supported. I may update older versions if there are any major bugs/oversights, but will not be backporting new features to them.

**Q: Fabric port?**

A: I have **No** plans on porting to Fabric, but you are more than welcome to do so. I only ask for credit if you do.
</details>