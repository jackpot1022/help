package javaFile;


public class Block {
	public String blockColor;
	public String blockAbility;
}

class SpecialBlock extends Block{
	
	class NomalBlock{
		public NomalBlock(){
			blockColor = "WHITE";
			blockAbility = "Player stop";		
		}
	}
	
	class DisappearBlock{
		public DisappearBlock() {
			blockColor = "SKY BLUE";
			blockAbility = "Block disappear";
			boolean disappear = false;
		}
	}
	
	abstract class ShootBlock{
		public ShootBlock(String direction) {
			blockColor = direction;
			blockAbility = "Shoot player to" + direction;
		}
	}
	
	class ActiveBlock{
		public ActiveBlock() {
			blockColor = "GRAY";
			blockAbility = "Block active/inactive";
			boolean active = true;
		}
	}
}

class ThornBlock extends Block{
	public ThornBlock(){
		blockColor = "RED";
		blockAbility = "Player death";
	}
}

class ObjectBlock extends Block{
	
	class DoorBlock{
		public DoorBlock() {
			blockColor = "YELLOW";
			blockAbility = "Clear Stage";
			boolean opened = true;
		}
		
	}
	
	class KeyBlock{
		public KeyBlock() {
			blockColor = "ORANGE";
			blockAbility = "Open door";
			boolean gained = false;
		}
	}
}
