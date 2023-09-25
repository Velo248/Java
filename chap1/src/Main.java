/*
레스토랑 주문 정보를 받고, 셰프에게 메뉴가 전달된 후 손님에게 전달 되기까지의 과정 구현

홀 직원이 주문 정보를 받고 메뉴를 셰프에게 주문합니다.
레스토랑에서 다루는 음식은 총 4가지 종류입니다.

1. 한식
2. 일식
3. 중식
4. 양식

각 음식의 종류마다 셰프가 존재합니다. 프로세스는 아래와 같습니다.
- 홀 직원이 메뉴를 접수하면 셰프가 요리를 합니다.
- 요리의 종류에 따라 배정되는 셰프가 구분됩니다.
- 셰프가 요리를 완성하면 어떠한 요리가 완성됐는지 홀 직원에게 알려줍니다. 팩토리 클래스

@Example
==== 어떠한 메뉴를 접수하시겠습니까? ====
1. 한식
2. 일식
3. 중식
4. 양식

한식이 선택 됐습니다.
==== 한식 메뉴를 선택하세요. ====
1. 비빔밥 2. 물냉면 3.비빔냉면 4. 파전

==== 요리사가 요리를 준비중입니다. ====
비빔밥이 완성됐습니다.

@정보
한식, 일식, 중식, 양식의 메뉴는 임의로 4가지 정합니다.

@요구사항
Chef Class와 Menu Class, CookFactory Class를 구현하여 주세요.
추가적인 Class 구현이 필요한 경우 별도로 구현해도 좋습니다.
	단 Interface 및 Enum, Abstract를 적극 사용해 주세요.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userSelectChef;
        int userSelectMenu;

        System.out.println("==== 어떠한 메뉴를 접수하시겠습니까? ====");
        System.out.println("""
                1. 한식
                2. 일식
                3. 중식
                4. 양식""");

        Scanner sc = new Scanner(System.in);
        userSelectChef = sc.nextInt();

        if (userSelectChef > 4) {
            System.out.println("1~4의 숫자를 입력.");
            return;
        }

        CookFactory cookFactory = new CookFactory(userSelectChef);

        System.out.println(cookFactory.getSelectedChef() + "이 선택 됐습니다.");
        System.out.println("==== " + cookFactory.getSelectedChef() + " 메뉴를 선택하세요. ====");

        cookFactory.foodPreview();

        userSelectMenu = sc.nextInt();
        System.out.println("==== 요리사가 요리를 준비중입니다. ====");

        cookFactory.userMenuOrder(userSelectMenu);
        sc.close();
    }
}
