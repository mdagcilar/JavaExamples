package com.development.metindagcilar.List;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {
        List<String> ids = getIds();

        Set<String> deduplicatedIds = ids.stream().collect(Collectors.toSet());

        if (ids.size() == deduplicatedIds.size()) {
            System.out.println("No duplicates");
        } else {
            System.out.println("Duplicates found: " + (ids.size() - deduplicatedIds.size()));
        }
    }

    private static List<String> getIds() {
        return Arrays.asList(
                "9d299c1e-1f94-44f1-ac37-93b0454b1ab8",
                "a62d01ae-e127-4dbd-8426-a84f1498aadf",
                "886273bb-7af2-496d-b95b-c28ff74f3a31",
                "c16a8755-28ef-4994-8630-6d5ef5b0a5ba",
                "b4bd1e72-450f-452e-b958-d751acf8ab12",
                "0308e3b0-ac0e-44b0-ad28-b44c4012b02e",
                "d25201a3-167b-43ce-a369-a176b3279a32",
                "83335923-ebcc-42bb-9c81-94098d7cb305",
                "d5c681c2-2daf-4949-941a-fb133e3dfa48",
                "3b87b9ab-231a-4f4b-be07-fa97d308546f",
                "d81934ea-2445-435c-a6f7-496a99a42a91",
                "b7ee8c7c-352a-493c-aae9-79685302ef94",
                "0cc76fb9-3296-4eb9-ac92-5e82f514b914",
                "3628dc7e-c879-4e72-8e06-3d2e9088602b",
                "63f6887c-cc05-400e-a8cc-df07c31986d3",
                "0895c3ff-7338-4a5a-9de5-f8d1431c1137",
                "5f8163b3-a537-409c-8e81-e631a2b66749",
                "60bc247d-e8ee-4e4f-85f2-cfea6ed00ba8",
                "33fecf6d-7c54-4acb-b860-3f8e36f6d5cb",
                "7b6b465f-b876-44ee-b674-2a8c2a9c1ff5",
                "7a323067-4d65-4477-b4c9-6cbd43ee0af0"
        );
    }

}
