//reules
parser grammar dart_parse;
options {tokenVocab=dart_lexar;}

// base declarations start code
topTreeDeclaration :
    (allClassesDeclaration
    |dartVariabelsDeclaration)*
    ;

allClassesDeclaration:
    classDeclaration
    |statefullClassDeclaration
    |statelessClassDeclaration
    ;

classDeclaration :
    CLASS
    NAME
    CRLY_BRKT_OP
    dartVariabelsDeclaration*
    CRLY_BRKT_CL
    ;

statelessClassDeclaration :
    CLASS
    NAME
    STATELESS
    CRLY_BRKT_OP
    dartVariabelsDeclaration*
    buildMethodDeclaration
    CRLY_BRKT_CL
    ;

statefullClassDeclaration :
    stfulFirstBody
    stfulSecondBody
    ;

stfulFirstBody:
    CLASS
    NAME
    STATEFULL
    CRLY_BRKT_OP
    dartVariabelsDeclaration*
    statefullAssignStateClassDeclaration
    CRLY_BRKT_CL
;

stfulSecondBody:
    CLASS
    NAME
    EXTENDS
    STATE
    ANGLE_BRKT_OP
    NAME
    ANGLE_BRKT_CL
    CRLY_BRKT_OP
    dartVariabelsDeclaration*
    buildMethodDeclaration
    CRLY_BRKT_CL
;

statefullAssignStateClassDeclaration:
    STATE
    ANGLE_BRKT_OP
    NAME
    ANGLE_BRKT_CL
    CREATESTATE
    BRKT_OP
    BRKT_CL
    returnStateTypes
    ;

returnStateTypes:
    returnArrowState
    |functionReturnState
    ;

functionReturnState:
    CRLY_BRKT_OP
    RETURN
    NAME
    BRKT_OP
    BRKT_CL
    SEMICOLON
    CRLY_BRKT_CL
    ;

returnArrowState:
    ASSIGN
    ANGLE_BRKT_CL
    NAME
    BRKT_OP
    BRKT_CL
    SEMICOLON
    ;

buildMethodDeclaration:
    WIDGET
    BUILD
    BRKT_OP
    buildContextDeclaration
    BRKT_CL
    CRLY_BRKT_OP
    dartVariabelsDeclaration*
    RETURN
    widgetsDeclaration
    SEMICOLON
    CRLY_BRKT_CL
    ;


// dart declarations
dartVariabelsDeclaration:
    variable
    |function
    |dartAllListsDeclaration
    ;

// dart int, string, bool

variable:
    (FINAL | CONST)?
    (integerDeclaration
    |stringDeclaration
    |boolDeclaration
    |doubleDeclaration)
    SEMICOLON
    ;

integerDeclaration:
    INT?
    NAME
    (ASSIGN
    addExpression)?
    ;

doubleDeclaration:
    DOUBLE?
    NAME
    (ASSIGN
    addDoubleExpression)?
    ;
stringDeclaration:
    STRING?
    NAME
    (ASSIGN
    STRING_LINE)?
    ;

boolDeclaration:
    BOOL?
    NAME
    (ASSIGN
    booleans)?
    ;

addExpression
    :   multiplyExpression (('+'|'-') multiplyExpression)*
    ;

multiplyExpression
    :   number (('*' | '/') number)*
    ;

addDoubleExpression
    :   multiplyDoubleExpression (('+'|'-') multiplyDoubleExpression)*
    ;

multiplyDoubleExpression
    :   (number|numberDouble) (('*' | '/') (number|numberDouble))*
    ;

booleans:
    TRUE
    |FALSE
    |booleanOperation
    ;

booleanOperation:
    (number|numberDouble|NAME)
    (EQUAL | NOTEQUAL | ANGLE_BRKT_CL | ANGLE_BRKT_OP | GRATEREQUAL | LESSEQUAL)
    (number|numberDouble|NAME)
    ;


// dart List<int>, List<String>, List<bool>


dartAllListsDeclaration:
    dartListStringDeclaration
    |dartListIntDeclaration
    |dartListBoolDeclaration
    ;

dartListStringDeclaration :
    LIST
    (ANGLE_BRKT_OP
    STRING
    ANGLE_BRKT_CL)?
    NAME
    ASSIGN
    SQR_BRKT_OP
    (STRING_LINE
    (COMMA STRING_LINE)*
    )?
    COMMA?
    SQR_BRKT_CL
    SEMICOLON
    ;

dartListIntDeclaration :
    LIST
    (ANGLE_BRKT_OP
    INT
    ANGLE_BRKT_CL)?
    NAME
    ASSIGN
    SQR_BRKT_OP
    (number
    (COMMA number)*
    )?
    COMMA?
    SQR_BRKT_CL
    SEMICOLON
    ;
dartListBoolDeclaration :
    LIST
    (ANGLE_BRKT_OP
    BOOL
    ANGLE_BRKT_CL)?
    NAME
    ASSIGN
    SQR_BRKT_OP
    (booleans
    (COMMA booleans)*
    )?
    COMMA?
    SQR_BRKT_CL
    SEMICOLON
    ;


// flutter declaration

widgetsDeclaration:
    conatinerDeclaration
    |expandedDeclaration
    |materialButtonDeclaration
    |materialAppDeclaration
    |scaffoldDeclaration
    |paddingDeclaration
    |rowColumnDeclaration
    |textDeclaration
    |imageDeclaration
;

expandedDeclaration:
    EXPANDED
    BRKT_OP
    childPropertyDeclaration
    COMMA?
    BRKT_CL
    ;
paddingDeclaration:
    PADDING
    BRKT_OP
   ((paddingPropertyDeclaration COMMA
     childPropertyDeclaration)
    |(
    childPropertyDeclaration COMMA
    paddingPropertyDeclaration
    ))
    COMMA?
    BRKT_CL
    ;

scaffoldDeclaration:
    SCAFFOLD
    BRKT_OP
    bodyPropertyDeclaration
    COMMA?
    BRKT_CL
    ;

textDeclaration:
    TEXT
    BRKT_OP
    STRING_LINE
    COMMA?
    BRKT_CL
    ;

materialAppDeclaration:
    MATERIALAPP
    BRKT_OP
    homePropertyDeclaration
    COMMA?
    BRKT_CL
    ;

materialButtonDeclaration:
    MATERIALBUTTON
    BRKT_OP
    onPressedPropertyDeclaration
    childPropertyDeclaration
    COMMA?
    BRKT_CL
    ;

conatinerDeclaration:
    CONTAINER
    BRKT_OP
    conatinerPropertiesDeclaration?
    (COMMA conatinerPropertiesDeclaration)*
    COMMA?
    BRKT_CL
    ;
rowColumnDeclaration:
    (ROW|COLUMN)
    BRKT_OP
    childrenPropertyDeclaration
    COMMA?
    BRKT_CL
    COMMA?
    ;
imageDeclaration:
    IMAGE
    DOT
    NETWORK
    BRKT_OP
    (NAME|STRING_LINE)
    BRKT_CL
    ;



// flutter widgets properties declaration


conatinerPropertiesDeclaration:
    heightPropertyDeclaration
    |widthPropertyDeclaration
    |childPropertyDeclaration
    ;

paddingPropertyDeclaration:
    PADDINGSMALL
    COLON
    edgeInsistAll
    ;
edgeInsistAll:
    EDGEINSETS
    DOT
    ALL
    BRKT_OP
    number
    BRKT_CL
    ;

// todo add set state
onPressedPropertyDeclaration:
    ONPRESSED
    COLON
    BRKT_OP
    BRKT_CL
    CRLY_BRKT_OP
    (statement|setStatePressedDeclaration)*
    CRLY_BRKT_CL
    COMMA
    ;

setStatePressedDeclaration:
    SETSTATE
    BRKT_OP
    BRKT_OP
    BRKT_CL
    CRLY_BRKT_OP
    statement*
    CRLY_BRKT_CL
    BRKT_CL
    SEMICOLON
    ;

heightPropertyDeclaration:
    HEIGHT
    COLON
    number
    ;

widthPropertyDeclaration:
    WIDTH
    COLON
    number
    ;
homePropertyDeclaration:
    HOME
    COLON
    NAME
    BRKT_OP
    BRKT_CL
    ;

childPropertyDeclaration:
    CHILD
    COLON
    widgetsDeclaration
    ;

childrenPropertyDeclaration:
    CHILDREN
    COLON
    SQR_BRKT_OP
    (widgetsDeclaration
    (COMMA widgetsDeclaration)*)?
    COMMA?
    SQR_BRKT_CL
    ;
bodyPropertyDeclaration:
    BODY
    COLON
    widgetsDeclaration
    ;

buildContextDeclaration:
    BUILDCONTEXT
    NAME
    ;
number:
NUMBER
;
numberDouble:
NUMBERDOUBLE
;



/// dart statements

ifStatement:
    IF
    BRKT_OP
    booleanOperation
    BRKT_CL
    block
    (ELSEIF block)*
    (ELSE block)?
    ;

whileStatement:
    WHILE
    BRKT_OP
    booleanOperation
    BRKT_CL
    block
    ;


block:
    CRLY_BRKT_OP
    statement*
    CRLY_BRKT_CL
    ;
function:
    (
    (FUNCTION? functionType)
    |FUNCTION
    )
    NAME '(' parameters? ')' block
    ;
functionType:
    (STRING | INT | DOUBLE| BOOL| VAR| VOID)
    ;

parameters:
    dartVariabelsDeclaration
    (',' dartVariabelsDeclaration)*
    COMMA?
    ;

statement:
    dartVariabelsDeclaration
    |ifStatement
    |whileStatement
    |function
    ;

forStatement:
    FOR
    BRKT_OP
    (integerDeclaration | doubleDeclaration)
    SEMICOLON
    booleanOperation
    SEMICOLON
    (integerDeclaration | doubleDeclaration)
    BRKT_CL
    block
    ;

