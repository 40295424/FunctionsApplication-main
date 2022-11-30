<?php

require_once('../../../main/php/qubgrademeMinMax/functions.inc.php');
use PHPUnit\Framework\TestCase;

class Test extends TestCase
{

    function testSortedModules()
    {

        $modules1 = "modules1";
        $modules2 = "modules2";
        $modules3 = "modules3";
        $modules4 = "modules4";
        $modules5 = "modules5";
        $sorted1 =  "modules5 - 50";
        $sorted2 =  "modules1 - 10";
        $modules = array($modules2, $modules1, $modules4, $modules3, $modules5);
        $marks = array(20, 10, 40, 30, 50);
        $expected = array($sorted1,$sorted2);;

        $MinMax = getMaxMin($modules,$marks);

        $this->assertSame($expected, $MinMax);
    }
    public function testWithValidRequest()
    {
        $expectedOutput = '{"error":false,"modules":["m1","m3","m4","m5","m6"],"marks":["16","12","12","12","122"],"max_module":"m6 - 122","min_module":"m5 - 12"}';
        $curl = curl_init("http://maxmin.esha.qpc.hal.davecutting.uk/?module_1=m1&module_2=m3&module_3=m4&module_4=m5&module_5=m6&mark_1=16&mark_2=12&mark_3=12&mark_4=12&mark_5=122");
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);

        $output = curl_exec($curl);
        print(gettype($output));
        $code = curl_getinfo($curl, CURLINFO_HTTP_CODE);

        curl_close($curl);

        $this->assertEquals(
            200,
            $code
        );
        $this->assertEquals(
            $expectedOutput,
            $output
        );
    }
}
