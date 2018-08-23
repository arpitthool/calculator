package com.example.arpit.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0,
            btn_Add,btn_Sub,btn_Mul,btn_Div,btn_calc,btn_clear,btn_pow,
            btn_right_par, btn_left_par,btn_dec,btn_equal, btn_backspace ;
    EditText exp , ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = (Button) findViewById(R.id.zero);
        btn_1 = (Button) findViewById(R.id.one);
        btn_2 = (Button) findViewById(R.id.two);
        btn_3 = (Button) findViewById(R.id.three);
        btn_4 = (Button) findViewById(R.id.four);
        btn_5 = (Button) findViewById(R.id.five);
        btn_6 = (Button) findViewById(R.id.six);
        btn_7 = (Button) findViewById(R.id.seven);
        btn_8 = (Button) findViewById(R.id.eight);
        btn_9 = (Button) findViewById(R.id.nine);
        btn_Add = (Button) findViewById(R.id.add);
        btn_Div = (Button) findViewById(R.id.divide);
        btn_Sub = (Button) findViewById(R.id.subtract);
        btn_Mul = (Button) findViewById(R.id.multiply);
        btn_calc = (Button) findViewById(R.id.equals);
        btn_pow = (Button) findViewById(R.id.power);
        btn_clear = (Button) findViewById(R.id.clear);
        btn_right_par = (Button) findViewById(R.id.right_par);
        btn_left_par = (Button) findViewById(R.id.left_par);
        btn_dec = (Button) findViewById(R.id.decimal);
        btn_equal = (Button) findViewById(R.id.equals);
        btn_backspace = (Button) findViewById(R.id.back);

        exp = (EditText) findViewById(R.id.expression);
        ans = (EditText) findViewById(R.id.answer);

        btn_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = exp.getText().toString();
                if( expression.length() > 0) {
                    exp.setText( expression.substring(0, expression.length() - 1) );
                }
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"9");
            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+".");
            }
        });

        btn_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"*");
            }
        });

        btn_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"-");
            }
        });

        btn_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"/");
            }
        });

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"+");
            }
        });

        btn_pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"^");
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText("");
                ans.setText("");
            }
        });

        btn_right_par.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+")");
            }
        });

        btn_left_par.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText()+"(");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(""+evaluate(exp.getText().toString()));
            }

            public int evaluate(String expression)
            {
                char[] tokens = expression.toCharArray();

                Stack<Integer> values = new Stack<>();

                Stack<Character> ops = new Stack<>();

                for (int i = 0; i < tokens.length; i++)
                {
                    if (tokens[i] == ' ')
                        continue;

                    // Current token is a number, push it to stack for numbers
                    if (tokens[i] >= '0' && tokens[i] <= '9')
                    {   /*
                        String sbuf = new String("");
                        // There may be more than one digits in number
                        while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                            sbuf.append(tokens[i++]);
                        values.push(Integer.parseInt(sbuf.toString()));
                        */
                        values.push(Integer.parseInt(tokens[i] + ""));
                    }

                    else if (tokens[i] == '(')
                        ops.push(tokens[i]);

                    else if (tokens[i] == ')')
                    {
                        while (ops.peek() != '(')
                            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                        ops.pop();
                    }

                    else if (tokens[i] == '+' || tokens[i] == '-' ||
                            tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^')
                    {
                        // While top of 'ops' has same or greater precedence to current
                        // token, which is an operator. Apply operator on top of 'ops'
                        // to top two elements in values stack
                        while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                        // Push current token to 'ops'.
                        ops.push(tokens[i]);
                    }
                }

                // Entire expression has been parsed at this point, apply remaining
                // ops to remaining values
                while (!ops.empty())
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Top of 'values' contains result, return it

                return values.pop();

            }

            // Returns true if 'op2' has higher or same precedence as 'op1',
            // otherwise returns false.
            public boolean hasPrecedence(char op1, char op2) {
                if (op2 == '(' || op2 == ')')
                    return false;
                if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
                    return false;
                if ((op1 == '^') && (op2 == '*' || op2 == '/'||op2 == '+' || op2 == '-'))
                    return false;
                else
                    return true;
            }

            public int applyOp(char op, int b, int a) {
                switch (op)
                {
                    case '+':
                        return a + b;
                    case '-':
                        return a - b;
                    case '*':
                        return a * b;
                    case '/':
                        if (b == 0)
                            throw new
                                    UnsupportedOperationException("Cannot divide by zero");
                        return a / b;
                    case '^':
                        return (int)(Math.pow(a,b));
                }
                return 0;
            }
        });




    }

}
