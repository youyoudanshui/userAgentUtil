package cn.wmj.enumerate;

/**
 * 移动设备型号
 * @author wmj
 *
 */
public enum ModelEnum {
	
	IPAD("iPad", "iPad"),
	IPOD("iPod", "iPod"),
	IPhone("iPhone", "iPhone"),

	HONOR7("荣耀7", "PLK-AL10"),
	HONOR8("荣耀8", "FRD-AL10"),
	HONOR10QCB("荣耀10 青春版", "HRY-AL00"),
	HONOR30PRO("荣耀30 Pro", "EBG-AN00"),
	HONOR30PROPLUS("荣耀30 Pro+", "EBG-AN10"),
	HONOR50("荣耀50", "NTH-AN00"), // 20210625
	HONOR50PRO("荣耀50 Pro", "RNA-AN00"),
	HONOR50SE("荣耀50 SE", "JLH-AN00"),
	HONOR60("荣耀60", "LSA-AN00"),
	HONOR60PRO("荣耀60 Pro", "TNA-AN00"),
	HONOR60SE("荣耀60 SE", "GIA-AN00"),
	HONOR70("荣耀70", "FNE-AN00"),
	HONOR70PRO("荣耀70 Pro", "SDY-AN00"),

	HONORMAGIC3("荣耀 Magic3", "ELZ-AN00"),
	HONORMAGIC3PRO("荣耀 Magic3 Pro", "ELZ-AN10"),
	HONORMAGIC3ZZB("荣耀 Magic3 至臻版", "ELZ-AN20"),
	HONORMAGICV("荣耀 Magic V", "MGI-AN00"),
	HONORMAGIC4("荣耀 Magic4", "LGE-AN00"),
	HONORMAGIC4PRO("荣耀 Magic4 Pro", "LGE-AN10"),

	HONORX10("荣耀 X10", "TEL-AN00a"),
	HONORX20SE("荣耀 X20 SE", "CHL-AN00"),
	HONORX20("荣耀 X20", "NTN-AN20"),
	HONORX30I("荣耀 X30i", "TFY-AN00"),
	HONORX30MAX("荣耀 X30 Max", "KKG-AN70"),
	HONORX30("荣耀 X30", "ADY-AN00"),

	HONORCW20("荣耀 畅玩20", "KOZ-AL00"),
	HONORPLAY5THLB("荣耀 Play5T 活力版", "NZA-AL00"),
	HONORPLAY5("荣耀 Play5", "HJC-AN90"),
	HONORPLAY5T("荣耀 Play5T", "KOZ-AL40"),
	HONORPLAY5TPRO("荣耀 Play5T Pro", "CHL-AL00"),
	HONORPLAY5HLB("荣耀 Play5 活力版", "NEW-AN90"),
	HONORCW30PLUS("荣耀 畅玩30 Plus", "CMA-AN00"),
	HONORPLAY6TPRO("荣耀 Play6T Pro", "TFY-AN40"),
	HONORPLAY6T("荣耀 Play6T", "CMA-AN40"),

	HONORV10("荣耀 V10", "BKL-AL20"),
	HONORV30PRO("荣耀 V30 Pro", "OXF-AN10"),
	HONORV40QSB("荣耀 V40 轻奢版", "ALA-AN70"),


	HUAWEIP20("华为 P20", "EML-AL00"),
	HUAWEIP30("华为 P30", "ELE-AL00"),
	HUAWEIP30PRO("华为 P30 Pro", "VOG-AL00"),
	HUAWEIP30PROZXB("华为 P30 Pro 尊享版", "VOG-AL10"),
	HUAWEIP40("华为 P40", "ANA-AL00"),
	HUAWEIP40PROPLUS("华为 P40 Pro+", "ELS-AN10"),
	HUAWEIP50PRO("华为 P50 Pro", "JAD-AL50"),
	HUAWEIP50("华为 P50", "ABR-AL00"),
	HUAWEIP50POCKET("华为 P50 Pocket", "BAL-AL00"),
	HUAWEIP50E("华为 P50E", "ABR-AL60"),

	HUAWEIMATE20("华为 Mate 20", "HMA-AL00"),
	HUAWEIMATE30("华为 Mate 30", "TAS-AL00"),
	HUAWEIMATE30PRO("华为 Mate 30 Pro", "LIO-AN00"),
	HUAWEIMATE30EPRO("华为 Mate 30E Pro", "LIO-AN00m"),
	HUAWEIMATE40PRO("华为 Mate 40 Pro", "NOH-AL00"),
	HUAWEIMATE40RS("华为 Mate 40 RS 保时捷设计 典藏版", "NOP-AN00"),
	HUAWEIMATE40("华为 Mate 40", "OCE-AN10"),
	HUAWEIMATEX2("华为 Mate X2", "TET-AN00"),
	HUAWEIMATE40E("华为 Mate 40E", "OCE-AL50"),
	HUAWEIMATEXS2("华为 Mate Xs 2", "PAL-AL00"),

	HUAWEINOVA2S("华为 nova 2S", "HWI-AL00"),
	HUAWEINOVA4("华为 nova 4", "VCE-AL00"),
	HUAWEINOVA5PRO("华为 nova 5 Pro", "SEA-AL10"),
	HUAWEINOVA5Z("华为 nova 5z", "SPN-AL00"),
	HUAWEINOVA7("华为 nova 7", "JEF-AN00"),
	HUAWEINOVA7PRO("华为 nova 7 Pro", "JER-AN10"),
	HUAWEINOVA8SE("华为 nova 8 SE", "JSC-AL50"),
	HUAWEINOVA8("华为 nova 8", "ANG-AN00"),
	HUAWEINOVA8PRO("华为 nova 8 Pro", "BRQ-AN00"),
	HUAWEINOVA8SEHLB("华为 nova 8 SE 活力版", "CHL-AL60"),
	HUAWEINOVA9("华为 nova 9", "NAM-AL00"),
	HUAWEINOVA9PRO("华为 nova 9 Pro", "RTE-AL00"),
	HUAWEINOVA9SE("华为 nova 9 SE", "JLN-AL00"),

	HUAWEICX9("华为 畅享9", "DUB-AL00"),
	HUAWEICX10PLUS("华为 畅享10 Plus", "STK-AL00"),
	HUAWEICX10("华为 畅享10", "ART-AL00x"),
	HUAWEICX10E("华为 畅享10e", "MED-AL00"),
	HUAWEICX20PRO("华为 畅享20 Pro", "DVC-AN20"),
	HUAWEICX20("华为 畅享20", "WKG-AN00"),
	HUAWEICX20PLUS("华为 畅享20 Plus", "FRL-AN00a"),
	HUAWEICX20E("华为 畅享20e", "MLD-AL10"),
	HUAWEICX50("华为 畅享50", "MGA-AL00"),
	
	HUAWEIMM8("华为 麦芒8", "POT-AL10"),


	VIVOX27("vivo X27", "V1829A"),
	VIVOX27PRO("vivo X27 Pro", "V1836A"),
	VIVOX50("vivo X50", "V2001A"),
	VIVOX50PROPLUS("vivo X50 Pro+", "V2011A"),
	VIVOX60("vivo X60", "V2046A"),
	VIVOX60PRO("vivo X60 Pro", "V2047A"),
	VIVOX60PROPLUS("vivo X60 Pro+/X60t Pro+", "V2056A"),
	VIVOX60QPB("vivo X60 曲屏版", "V2059A"),
	VIVOX70T("vivo X70t", "V2132A"),
	VIVOX70("vivo X70", "V2133A"),
	VIVOX70PRO("vivo X70 Pro", "V2134A"),
	VIVOX70PROPLUS("vivo X70 Pro+", "V2145A"),
	VIVOX80("vivo X80", "V2183A"),
	VIVOX80PRO("vivo X80 Pro", "V2185A"),

	VIVOS5("vivo S5", "V1932A"),
	VIVOS7E("vivo S7e/S7e 活力版", "V2031EA"),
	VIVOS9E("vivo S9e", "V2048A"),
	VIVOS9("vivo S9", "V2072A"),
	VIVOS10("vivo S10/S10 Pro", "V2121A"),
	VIVOS10E("vivo S10e", "V2130A"),
	VIVOS12("vivo S12", "V2162A"),
	VIVOS12PRO("vivo S12 Pro", "V2163A"),
	VIVOS15E("vivo S15e", "V2190A"),
	VIVOS15("vivo S15", "V2203A"),
	VIVOS15PRO("vivo S15 Pro", "V2207A"),

	VIVOT1("vivo T1", "V2115A"),
	VIVOT1X("vivo T1x/Y53s(t2版)", "V2123A"),

	VIVOY3("vivo Y3/Y3s", "V1901A"),
	VIVOY3BZB("vivo Y3 标准版", "V1930A"),
	VIVOY5S("vivo Y5s", "V1934A"),
	VIVOY9S("vivo Y9s", "V1945A"),
	VIVOY50("vivo Y50", "V1965A"),
	VIVOY70S("vivo Y70s/Y70t", "V2002A"),
	VIVOY50T("vivo Y50t", "V2023EA"),
	VIVOY30("vivo Y30", "V2034A"),
	VIVOY30BZB("vivo Y30 标准版", "V2036A"),
	VIVOY31S("vivo Y31s/Y52s(t1版)", "V2054A"),
	VIVOY52S("vivo Y52s", "V2057A"),
	VIVOY30G("vivo Y30g", "V2066BA"),
	VIVOY31SBZB("vivo Y31s 标准版/Y31s(t1版)", "V2068A"),
	VIVOY71T("vivo Y71t", "V2102A"),
	VIVOY53S("vivo Y53s", "V2111A"),
	VIVOY76S("vivo Y76s", "V2156A"),
	VIVOY32("vivo Y32", "V2158A"),
	VIVOY55S("vivo Y55s", "V2164A"),
	VIVOY33S("vivo Y33s", "V2166A"),
	VIVOY10("vivo Y10(t1版)", "V2168A"),

	VIVOZ5X("vivo Z5x", "V1911A"),
	VIVOZ5I("vivo Z5i", "V1941A"),

	VIVOXFOLD("vivo X Fold", "V2178A"),

	VIVOXNOTE("vivo X Note", "V2170A"),


	SAMSUNGGZFLIP("三星 Galaxy Z Flip", "SM-F7070"),
	SAMSUNGGZFLIP3("三星 Galaxy Z Flip3", "SM-F7110"),
	SAMSUNGGZFOLD2("三星 Galaxy Z Fold2", "SM-F9160"),
	SAMSUNGGZFOLD3("三星 Galaxy Z Fold3", "SM-F9260"),

	SAMSUNGGS20FE("三星 Galaxy S20 FE", "SM-G7810"),
	SAMSUNGGS5("三星 Galaxy S5", "SM-G900P"),
	SAMSUNGGS8PLUS("三星 Galaxy S8+", "SM-G955U"),
	SAMSUNGGS20("三星 Galaxy S20", "SM-G981B"),
	SAMSUNGGS20U("三星 Galaxy S20 Ultra", "SM-G9880"),
	SAMSUNGGS21FE("三星 Galaxy S21 FE", "SM-G9900"),
	SAMSUNGGS21("三星 Galaxy S21", "SM-G9910"),
	SAMSUNGGS21PLUS("三星 Galaxy S21+", "SM-G9960"),
	SAMSUNGGS21U("三星 Galaxy S21 Ultra", "SM-G9980"),
	SAMSUNGGS22("三星 Galaxy S22", "SM-S9010"),
	SAMSUNGGS22PLUS("三星 Galaxy S22+", "SM-S9060"),
	SAMSUNGGS22U("三星 Galaxy S22 Ultra", "SM-S9080"),

	SAMSUNGGN2("三星 Galaxy Note2", "GT-N7100"),
	SAMSUNGGN20("三星 Galaxy Note20", "SM-N9810"),
	SAMSUNGGN20U("三星 Galaxy Note20 Ultra", "SM-N9860"),

	SAMSUNGGA5("三星 Galaxy A5", "SM-A5000"),
	SAMSUNGGA51("三星 Galaxy A51", "SM-A5160"),
	SAMSUNGGA52("三星 Galaxy A52", "SM-A5260"),
	SAMSUNGGA53("三星 Galaxy A53", "SM-A5360"),
	SAMSUNGGA71("三星 Galaxy A71", "SM-A7160"),
	SAMSUNGGA90("三星 Galaxy A90", "SM-A9080"),
	
	SAMSUNGGF52("三星 Galaxy F52", "SM-E5260"),

	SAMSUNGW21("三星 W21", "SM-W2021"),
	SAMSUNGW22("三星 W22", "SM-W2022"),


	REALMEGT("真我 GT", "RMX2202"),
	REALMEGT2PRO("真我 GT2 Pro", "RMX3300"),
	REALMEGT2("真我 GT2", "RMX3310"),
	REALMEGTDSB("真我 GT 大师版", "RMX3361"),
	REALMEGTDSTSB("真我 GT 大师探索版", "RMX3366"),

	REALMEGTNEO("真我 GT Neo", "RMX3031"),
	REALMEGTNeoSSB("真我 GT Neo 闪速版", "RMX3350"),
	REALMEGTNeo2T("真我 GT Neo2T", "RMX3357"),
	REALMEGTNEO2("真我 GT Neo2", "RMX3370"),
	REALMEGTNEO3("真我 GT Neo3", "RMX3560"),
	REALMEGTNEO3HYXDB("真我 GT Neo3 火影限定版", "RMX3562"),
	

	REALMEQ5PRO("真我 Q5 Pro", "RMX3372"),
	REALMEQ3S("真我 Q3s", "RMX3461"),
	REALMEQ5("真我 Q5", "RMX3478"),
	REALMEQ5I("真我 Q5i", "RMX3574"),

	REALMEV15("真我 V15", "RMX3092"),
	REALMEV25("真我 V25", "RMX3475"),
	REALMEV23("真我 V23", "RMX3571"),

	MINOTE2("小米 Note 2", "Mi Note 2"),
	MI6("小米6", "MI 6"),
	MI8("小米8", "MI 8"),
	MI10("小米10", "Mi 10"),
	MI10ZZJNB("小米10 至尊纪念版", "M2007J1SC"),

	REDMIK20PRO("Redmi K20 Pro", "Redmi K20 Pro Build"),
	REDMIK20PROZXB("Redmi K20 Pro 尊享版", "Redmi K20 Pro Premium Edition"),


	LENOVOA850PLUS("联想 A850+", "Lenovo A850+"),
	LENOVOZ6PRO("联想 Z6 Pro", "Lenovo L78051"),

	
	IPLAY40("酷比魔方 iPlay40", "iPlay40"),

	_360N6("360 N6", "1707-A01"),

	UROVOI9000S("优博讯 i9000S", "i9000S"),
	

	BBPLAYBOOK("黑莓PlayBook", "PlayBook"),
	
	BB10("黑莓手机", "BB10")
	;
	
	private final String name;
	private String modelString;
	
	ModelEnum(String name) {
		this.name = name;
	}
	
	ModelEnum(String name, String modelString) {
		this.name = name;
		this.modelString = modelString;
	}

	public String getName() {
		return name;
	}

	public String getModelString() {
		return modelString;
	}

}
