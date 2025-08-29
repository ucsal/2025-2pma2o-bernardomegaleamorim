[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/uhBuZyxk)
# Aula 2.2 — Atividade: Open/Closed Principle (OCP)

## OBJETIVO: 
Aplicar o **Princípio Aberto/Fechado (OCP)** para eliminar a necessidade de modificar a classe `DiscountCalculator` sempre que surgir um novo tipo de cliente.  
Queremos que a calculadora fique **aberta para extensão** (novas políticas de desconto) e **fechada para modificação** (não precisa mais de `switch`/`if`).

---

## CONTEXTO:
Hoje a `DiscountCalculator` contém um `switch` em `CustomerType`:
```java
public double apply(double amount, CustomerType type){
    switch (type){
        case REGULAR: return amount * 0.95;
        case PREMIUM: return amount * 0.90;
        default: return amount;
    }
}
```

Isso viola o OCP porque, ao adicionar um novo tipo de cliente (`PARTNER`, por exemplo), somos obrigados a **editar** essa classe.  
No código legado, o tipo `PARTNER` não é tratado → os **testes existentes falham**.  
Sua tarefa é refatorar para respeitar OCP.  

---

## ESTRUTURA:
- **Pacote:** `br.com.mariojp.solid.ocp`  
- **Classes iniciais:**
  - `CustomerType.java` → Enum com `REGULAR, PREMIUM, PARTNER`  
  - `DiscountCalculator.java` → Implementação com `switch`  
- **Testes em:** `src/test/java/br/com/mariojp/solid/ocp/DiscountCalculatorTest.java`  
  - Verificam que `PARTNER` deve ter **12%** de desconto (100 → 88).  
  - Também verificam que a calculadora aceita **injeção de políticas de desconto**, sem depender de `switch`.

---

## Como rodar localmente
```bash
mvn -q test
```

---

## PASSO A PASSO 
1. **Clone** o repositório da atividade.  
2. Abra no **IDE** (IntelliJ / VS Code / Eclipse).  
3. Leia o código legado em `src/main/java/br/com/mariojp/solid/ocp/`.  
4. Rode os testes (`mvn -q test`) → eles **falham** inicialmente.  
5. Refatore aplicando OCP:  
   - Crie uma interface `DiscountPolicy` que define `apply(double amount)`.  
   - Implemente políticas concretas: `RegularPolicy`, `PremiumPolicy`, `PartnerPolicy`.  
   - Ajuste `DiscountCalculator` para **receber um mapa de políticas** (injeção).  
6. Garanta que **novos tipos** possam ser adicionados **sem modificar** `DiscountCalculator`.  
7. Rode novamente os testes até ficarem **verdes** .  
8. Faça **commits pequenos** e dê **push** no repositório.  

---

## AVALIAÇÃO (10 pts)
- Projeto compila (2 pts)  
- Refatoração remove `switch` e usa abstrações adequadas (3 pts)  
- Solução segue OCP: fácil adicionar novos descontos sem editar `DiscountCalculator` (3 pts)  
- Todos os testes passam (2 pts)  
